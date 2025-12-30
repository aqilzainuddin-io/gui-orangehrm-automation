package com.orangehrm.setup;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * EnvReader
 *
 * Responsible for reading environment variables from .env file.
 * Provides a centralized method to retrieve configuration values
 * such as HEADLESS mode, URLs, credentials, etc.
 */
public class EnvReader {

    // Load .env file from project root directory
    private static final Dotenv dotenv = Dotenv.configure()
            .directory("./")  // root directory of the project
            .ignoreIfMissing() // do not throw error if .env file is missing
            .load();

    /**
     * Get value of an environment variable from .env
     *
     * @param key the name of the environment variable
     * @return value associated with the key or null if not found
     */
    public static String get(String key) {
        return dotenv.get(key);
    }
}

// SPDX-License-Identifier: LGPL-3.0-only
package io.github.higorac.simulatedfarms.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CoreInfoTest {

    @Test
    void schemaVersionStartsAtOne() {
        assertEquals(1, CoreInfo.SCHEMA_VERSION);
    }

    @Test
    void dataFolderIsASingleSafeFolderName() {
        // The daemon may only touch files inside this folder (SECURITY.md, rule 2).
        assertTrue(CoreInfo.DATA_FOLDER.matches("[a-z0-9-]+"));
    }
}

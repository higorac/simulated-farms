// SPDX-License-Identifier: LGPL-3.0-only
package io.github.higorac.simulatedfarms.daemon;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void bannerNamesTheProjectAndSchema() {
        String banner = Main.banner();
        assertTrue(banner.startsWith("Simulated Farms daemon "));
        assertTrue(banner.endsWith("(schema v1)"));
    }
}

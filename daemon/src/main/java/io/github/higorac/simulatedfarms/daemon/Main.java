// SPDX-License-Identifier: LGPL-3.0-only
package io.github.higorac.simulatedfarms.daemon;

import io.github.higorac.simulatedfarms.core.CoreInfo;

/**
 * Entry point of the Simulated Farms daemon.
 *
 * <p>Phase 0 only prints its version. The simulation loop, lock file and terminal monitor are built in
 * Phase 1.
 */
public final class Main {

    private Main() {
    }

    public static void main(String[] args) {
        System.out.println(banner());
    }

    static String banner() {
        String version = Main.class.getPackage().getImplementationVersion();
        if (version == null) {
            version = "dev";
        }
        return "Simulated Farms daemon " + version + " (schema v" + CoreInfo.SCHEMA_VERSION + ")";
    }
}

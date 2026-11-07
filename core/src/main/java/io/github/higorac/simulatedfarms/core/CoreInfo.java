// SPDX-License-Identifier: LGPL-3.0-only
package io.github.higorac.simulatedfarms.core;

/**
 * Basic facts about the core module shared by the mod and the daemon.
 *
 * <p>The simulation engine itself is built in Phase 1. This class exists so the module compiles and the
 * build, test and CI pipeline can be verified in Phase 0.
 */
public final class CoreInfo {

    /** Version of the snapshot and result file formats written to {@code <world>/simulated-farms/}. */
    public static final int SCHEMA_VERSION = 1;

    /** Name of the folder, inside the world folder, that holds every file this project reads or writes. */
    public static final String DATA_FOLDER = "simulated-farms";

    private CoreInfo() {
    }
}

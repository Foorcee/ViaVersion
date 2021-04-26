/*
 * This file is part of ViaVersion - https://github.com/ViaVersion/ViaVersion
 * Copyright (C) 2016-2021 ViaVersion and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage;

import com.viaversion.viaversion.api.protocol.connection.StoredObject;
import com.viaversion.viaversion.api.protocol.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.Environment;

/**
 * Stored up until 1.14 to be used in chunk sending.
 */
public class ClientWorld extends StoredObject {
    private Environment environment;

    public ClientWorld(UserConnection user) {
        super(user);
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(int environmentId) {
        this.environment = Environment.getEnvironmentById(environmentId);
    }
}

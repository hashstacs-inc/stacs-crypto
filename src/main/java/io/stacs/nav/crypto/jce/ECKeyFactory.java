/*
 * Copyright (c) [2016] [ <ether.camp> ]
 * This file is part of the ethereumJ library.
 *
 * The ethereumJ library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The ethereumJ library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the ethereumJ library. If not, see <http://www.gnu.org/licenses/>.
 */
package io.stacs.nav.crypto.jce;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;

/**
 * The type Ec key factory.
 */
public final class ECKeyFactory {

    /**
     * The constant ALGORITHM.
     */
    public static final String ALGORITHM = "EC";

    private static final String ALGORITHM_ASSERTION_MSG =
            "Assumed the JRE supports EC key factories";

    private ECKeyFactory() {
    }

    private static class Holder {
        private static final KeyFactory INSTANCE;

        static {
            try {
                INSTANCE = KeyFactory.getInstance(ALGORITHM);
            } catch (NoSuchAlgorithmException ex) {
                throw new AssertionError(ALGORITHM_ASSERTION_MSG, ex);
            }
        }
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static KeyFactory getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * Gets instance.
     *
     * @param provider the provider
     * @return the instance
     * @throws NoSuchProviderException the no such provider exception
     */
    public static KeyFactory getInstance(final String provider) throws NoSuchProviderException {
        try {
            return KeyFactory.getInstance(ALGORITHM, provider);
        } catch (NoSuchAlgorithmException ex) {
            throw new AssertionError(ALGORITHM_ASSERTION_MSG, ex);
        }
    }

    /**
     * Gets instance.
     *
     * @param provider the provider
     * @return the instance
     */
    public static KeyFactory getInstance(final Provider provider) {
        try {
            return KeyFactory.getInstance(ALGORITHM, provider);
        } catch (NoSuchAlgorithmException ex) {
            throw new AssertionError(ALGORITHM_ASSERTION_MSG, ex);
        }
    }
}

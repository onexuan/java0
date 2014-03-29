/*
 * Copyright (C) 2014  Hugh Eaves
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
package org.java0.factory;

import java.util.logging.Logger;

/**
 * @author Hugh Eaves
 * 
 */
public abstract class AbstractTypedObjectProvider<T> implements
        TypedObjectProvider<T> {
    @SuppressWarnings("unused")
    private static final Logger logger = Logger
            .getLogger(AbstractTypedObjectProvider.class.getName());

    /**
     * The type to create / lookup
     */
    protected Class<? extends T> type;

    protected AbstractTypedObjectProvider(Class<? extends T> type) {
        this.type = type;
    }

    /**
     * @see org.java0.factory.ObjectProvider#getType()
     */
    @Override
    public Class<? extends T> getType() {
        return type;
    }
}
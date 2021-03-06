/*
 * Copyright (C) 2015  Hugh Eaves
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
package org.java0.cli;

import java.util.Map;

import org.java0.core.exception.UncheckedException;

import com.beust.jcommander.IDefaultProvider;
import com.beust.jcommander.ParameterException;

/**
 * An abstract class providing a default implementation of the {@link Command}
 * interface.
 */
public abstract class AbstractCommand implements Command {

    private final DefaultProviderMap defaultProviders = new DefaultProviderMap();

    /**
     * Validate.
     *
     * @throws ParameterException
     *             the parameter exception
     * @see org.java0.cli.Command#validate()
     */
    @Override
    public void validate() throws ParameterException {
    }

    @Override
    public void run() {
        try {
            runWithThrow();
        } catch (final Throwable e) {
            throw new UncheckedException(e);
        }
    }

    public void runWithThrow() throws Throwable {
        throw new UncheckedException("Must override run() or throwableRun()");
    }

    /**
     * @see org.java0.cli.Command#prepare()
     */
    @Override
    public Command prepare() {
        return this;
    }

    /**
     * @see org.java0.cli.Command#finish()
     */
    @Override
    public void finish() {

    }

    @Override
    public Map<String, IDefaultProvider> getDefaults() {
        return defaultProviders;

    }

    protected void addDefault(final String value, final String... optionNames) {
        for (final String optionName : optionNames) {
            if (defaultProviders.get(optionName) != null) {
                throw new ParameterException("Duplicate default value specified for option " + optionName);
            } else {
                defaultProviders.put(optionName, new IDefaultProvider() {
                    @Override
                    public String getDefaultValueFor(final String option) {
                        if (optionName.equals(option)) {
                            return value;
                        } else {
                            return null;
                        }
                    }
                });
            }

        }
    }
}

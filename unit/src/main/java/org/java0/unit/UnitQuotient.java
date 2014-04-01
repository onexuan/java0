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
package org.java0.unit;

// TODO: Auto-generated Javadoc
/**
 * The Interface NumericUnitQuotient.
 * 
 * @param <UNIT_1_TYPE>
 *            the generic type
 * @param <UNIT_2_TYPE>
 *            the generic type
 */
public interface UnitQuotient<UNIT_1_TYPE extends Unit<?, ?>, UNIT_2_TYPE extends Unit<?, ?>>
        extends
        BinaryUnit<UNIT_1_TYPE, UNIT_2_TYPE, UnitQuotient<UNIT_1_TYPE, UNIT_2_TYPE>> {

    /**
     * Returns this unit with the denominator unit cancelled by multiplying by
     * the given unit.
     * 
     * @param unit
     *            the unit
     * @return a unit
     */
    public UNIT_1_TYPE multiplyAndCancel2(UNIT_2_TYPE unit);

    /**
     * Returns this unit with the denominator unit cancelled by dividing by the
     * given unit.
     * 
     * @param unit
     *            the unit
     * @return a unit
     */
    public UNIT_1_TYPE divideAndCancel2(InverseUnit<?, ?> unit);

    /**
     * Returns this unit with the numerator unit cancelled by multiplying by the
     * given unit.
     * 
     * @param unit
     *            the unit
     * @return a unit
     */
    public UNIT_2_TYPE multiplyAndCancel1(InverseUnit<?, ?> unit);

    /**
     * Returns this unit with the numerator unit cancelled by dividing by the
     * given unit.
     * 
     * @param unit
     *            the unit
     * @return a unit
     */
    public UNIT_2_TYPE divideAndCancel1(UNIT_1_TYPE unit);
}
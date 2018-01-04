/**
 * Copyright (c) 2014,2017 by the respective copyright holders.
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.danfossairunit;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.smarthome.core.thing.ThingTypeUID;

/**
 * The {@link DanfossAirUnitBindingConstants} class defines common constants, which are
 * used across the whole binding.
 *
 * @author kaineuhaus - Initial contribution
 */
@NonNullByDefault
public class DanfossAirUnitBindingConstants {

    private static final String BINDING_ID = "danfossairunit";

    // List of all Thing Type UIDs
    public static final ThingTypeUID THING_TYPE_AIRUNIT = new ThingTypeUID(BINDING_ID, "danfossairunit");

    // List of all Channel ids
    public static final String CHANNEL_1 = "channel1";

}

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
package org.openhab.binding.danfossairunit.handler;

import static org.openhab.binding.danfossairunit.DanfossAirUnitBindingConstants.CHANNEL_1;

import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.smarthome.core.thing.ChannelUID;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingStatus;
import org.eclipse.smarthome.core.thing.ThingStatusDetail;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandler;
import org.eclipse.smarthome.core.types.Command;

import de.danfoss.airunit.model.AirUnit;
import de.danfoss.airunit.service.AirUnitController;
import de.danfoss.airunit.service.AirUnitControllerImpl;

/**
 * The {@link DanfossAirUnitHandler} is responsible for handling commands, which are
 * sent to one of the channels.
 *
 * @author kaineuhaus - Initial contribution
 */
@NonNullByDefault
public class DanfossAirUnitHandler extends BaseThingHandler {

    // private final Logger logger = LoggerFactory.getLogger(DanfossAirUnitHandler.class);
    private final AirUnitController controller;
    private AirUnit airUnit;

    public DanfossAirUnitHandler(Thing thing) {
        super(thing);
        controller = new AirUnitControllerImpl();
        airUnit = controller.getCurrentUnit();
    }

    @Override
    public void handleCommand(ChannelUID channelUID, Command command) {
        if (channelUID.getId().equals(CHANNEL_1)) {
            // TODO: handle command

            // Note: if communication with thing fails for some reason,
            // indicate that by setting the status with detail information
            // updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.COMMUNICATION_ERROR,
            // "Could not control device at IP address x.x.x.x");
        }
    }

    @Override
    public void initialize() {
        updateStatus(ThingStatus.INITIALIZING);

        List<AirUnit> findUnits = controller.findUnits();
        if (findUnits == null || findUnits.isEmpty()) {
            updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.NONE,
                    "Could not find any AirUnit with broadcast-message.");
            return;
        }
        // TODO: Initialize the thing. If done set status to ONLINE to indicate proper working.
        // Long running initialization should be done asynchronously in background.
        airUnit = findUnits.get(0);
        updateStatus(ThingStatus.ONLINE);

        // Note: When initialization can NOT be done set the status with more details for further
        // analysis. See also class ThingStatusDetail for all available status details.
        // Add a description to give user information to understand why thing does not work
        // as expected. E.g.
        // updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.CONFIGURATION_ERROR,
        // "Can not access device as username and/or password are invalid");
    }
}
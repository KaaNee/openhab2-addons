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
package org.openhab.binding.danfossairunit.internal;

import static org.openhab.binding.danfossairunit.DanfossAirUnitBindingConstants.THING_TYPE_DEVICE;

import java.util.Collections;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.smarthome.config.core.Configuration;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingTypeUID;
import org.eclipse.smarthome.core.thing.ThingUID;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandlerFactory;
import org.eclipse.smarthome.core.thing.binding.ThingHandler;
import org.eclipse.smarthome.core.thing.binding.ThingHandlerFactory;
import org.openhab.binding.danfossairunit.handler.DanfossAirUnitHandler;
import org.osgi.service.component.annotations.Component;

/**
 * The {@link DanfossAirUnitHandlerFactory} is responsible for creating things and thing
 * handlers.
 *
 * @author kaineuhaus - Initial contribution
 */
@Component(service = ThingHandlerFactory.class, immediate = true, configurationPid = "binding.danfossairunit")
@NonNullByDefault
public class DanfossAirUnitHandlerFactory extends BaseThingHandlerFactory {

    private static final Set<ThingTypeUID> SUPPORTED_THING_TYPES_UIDS = Collections.singleton(THING_TYPE_DEVICE);

    @Override
    public boolean supportsThingType(ThingTypeUID thingTypeUID) {
        return SUPPORTED_THING_TYPES_UIDS.contains(thingTypeUID);
    }

    @Override
    protected @Nullable ThingHandler createHandler(Thing thing) {
        ThingTypeUID thingTypeUID = thing.getThingTypeUID();

        if (thingTypeUID.equals(THING_TYPE_DEVICE)) {
            return new DanfossAirUnitHandler(thing);
        }

        return null;
    }

    @Override
    public ThingHandler registerHandler(Thing thing) {
        // TODO Auto-generated method stub
        return super.registerHandler(thing);
    }

    @Override
    public void unregisterHandler(Thing thing) {
        // TODO Auto-generated method stub
        super.unregisterHandler(thing);
    }

    @Override
    public void removeThing(ThingUID thingUID) {
        // TODO Auto-generated method stub
        super.removeThing(thingUID);
    }

    @Override
    public @Nullable Thing createThing(ThingTypeUID thingTypeUID, Configuration configuration,
            @Nullable ThingUID thingUID, @Nullable ThingUID bridgeUID) {
        // TODO Auto-generated method stub
        return super.createThing(thingTypeUID, configuration, thingUID, bridgeUID);
    }
}

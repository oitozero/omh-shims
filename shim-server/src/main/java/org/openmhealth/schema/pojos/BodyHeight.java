/*
 * Copyright 2014 Open mHealth
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openmhealth.schema.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.joda.time.DateTime;
import org.openmhealth.schema.pojos.generic.DescriptiveStatistic;
import org.openmhealth.schema.pojos.generic.LengthUnitValue;
import org.openmhealth.schema.pojos.generic.TimeFrame;

/**
 * @author Danilo Bonilla
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonRootName(value = BodyHeight.SCHEMA_BODY_HEIGHT, namespace = DataPoint.NAMESPACE)
public class BodyHeight extends BaseDataPoint {

    @JsonProperty(value = "body_height", required = true)
    private LengthUnitValue lengthUnitValue;

    @JsonProperty(value = "effective_time_frame", required = false)
    private TimeFrame effectiveTimeFrame;

    @JsonProperty(value = "descriptive_statistic", required = false)
    private DescriptiveStatistic descriptiveStatistic;

    public static final String SCHEMA_BODY_HEIGHT = "body_height";

    public BodyHeight() {
    }

    public BodyHeight(LengthUnitValue lengthUnitValue, TimeFrame effectiveTimeFrame) {
        this.lengthUnitValue = lengthUnitValue;
        this.effectiveTimeFrame = effectiveTimeFrame;
    }

    @Override
    @JsonIgnore
    public String getSchemaName() {
        return SCHEMA_BODY_HEIGHT;
    }

    @Override
    @JsonIgnore
    public DateTime getTimeStamp() {
        return effectiveTimeFrame.getTimestamp();
    }

    public DescriptiveStatistic getDescriptiveStatistic() {
        return descriptiveStatistic;
    }

    public void setDescriptiveStatistic(DescriptiveStatistic descriptiveStatistic) {
        this.descriptiveStatistic = descriptiveStatistic;
    }

    public LengthUnitValue getLengthUnitValue() {
        return lengthUnitValue;
    }

    public void setLengthUnitValue(LengthUnitValue lengthUnitValue) {
        this.lengthUnitValue = lengthUnitValue;
    }

    public TimeFrame getEffectiveTimeFrame() {
        return effectiveTimeFrame;
    }

    public void setEffectiveTimeFrame(TimeFrame effectiveTimeFrame) {
        this.effectiveTimeFrame = effectiveTimeFrame;
    }
}

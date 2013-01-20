/*
   Copyright (c) 2012 Emitrom LLC. All rights reserved. 
   For licensing questions, please contact us at licensing@emitrom.com

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package com.emitrom.lienzo.client.core.shape.json.validators;

import com.google.gwt.json.client.JSONValue;

public class LinearGradientValidator extends ObjectValidator
{
    public static final LinearGradientValidator INSTANCE = new LinearGradientValidator();

    public LinearGradientValidator()
    {
        super("LinearGradient");

        addAttribute("type", StringValidator.INSTANCE, true); // must be "LinearGradient"

        addAttribute("start", Point2DValidator.INSTANCE, true);

        addAttribute("end", Point2DValidator.INSTANCE, true);

        addAttribute("colorStops", ColorStopValidator.ARRAY_INSTANCE, true);
    }

    @Override
    public void validate(JSONValue jval, ValidationContext ctx) throws ValidationException
    {
        super.validate(jval, ctx);

        checkHardcodedAttribute("type", "LinearGradient", jval, ctx);
    }
}

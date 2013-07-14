/*
   Copyright (c) 2013 Emitrom LLC. All rights reserved. 
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

package com.emitrom.lienzo.client.core.shape.path;

import com.emitrom.lienzo.shared.core.types.EnumWithValue;

public enum PathPartType implements EnumWithValue
{
    m("m"), M("M"), l("l"), L("L"), h("h"), H("H"), v("v"), V("V"), c("c"), C("C"), s("s"), S("S"), a("a"), A("A"), q("q"), Q("Q"), t("t"), T("T"), z("z"), Z("Z"), UNKNOWN("unknown");

    private final String m_value;

    private PathPartType(String value)
    {
        m_value = value;
    }

    public final String getValue()
    {
        return m_value;
    }

    public static final PathPartType lookup(String key)
    {
        if ((null != key) && (false == (key = key.trim()).isEmpty()))
        {
            PathPartType[] values = PathPartType.values();

            for (int i = 0; i < values.length; i++)
            {
                PathPartType value = values[i];

                if (value.getValue().equals(key))
                {
                    return value;
                }
            }
        }
        return UNKNOWN;
    }
}

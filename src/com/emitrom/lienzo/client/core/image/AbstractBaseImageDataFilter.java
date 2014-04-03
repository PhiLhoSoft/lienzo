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

package com.emitrom.lienzo.client.core.image;

import com.emitrom.lienzo.client.core.types.ImageData;

public abstract class AbstractBaseImageDataFilter<T extends AbstractBaseImageDataFilter<T>> implements IBaseImageDataFilter<T>
{
    private boolean m_isnative = true;

    @Override
    public final boolean isNative()
    {
        return m_isnative;
    }

    @SuppressWarnings("unchecked")
    @Override
    public final T setNative(boolean isnative)
    {
        m_isnative = isnative;

        return (T) this;
    }

    @Override
    public final int getLength(ImageData source)
    {
        return ((source.getWidth() * source.getHeight()) * PIXEL_SZ);
    }
}

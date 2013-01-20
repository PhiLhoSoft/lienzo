package com.emitrom.lienzo.client.core.image;

import com.emitrom.lienzo.client.core.shape.Picture;

/**
 * PictureLoadedHandler is invoked when the image of a {@link Picture} has loaded.
 * 
 * @see Picture#onLoad(PictureLoadedHandler)
 * @see PictureLoader
 * @see Picture#onCategoryLoaded(String, Runnable)
 */
public interface PictureLoadedHandler
{
    public void onPictureLoaded(Picture picture);
}

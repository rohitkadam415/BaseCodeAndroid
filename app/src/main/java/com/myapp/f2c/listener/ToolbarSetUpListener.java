package com.myapp.f2c.listener;

/**
 * @author Rafique Mujawar
 * Date 02-08-2018
 */
public interface ToolbarSetUpListener {
  /**
   * Method to setup tool bar as per requirement
   * @param title title of screen, pass null or empty if title not required
   * @param titleImage resource id of title image, pass 0 to avoid title image
   * @param primaryImage resource id of starting image, pass 0 if not required
   * @param secondaryImage resource id of end image, pass 0 if not required
   */
  void setUpToolbar(String title, int titleImage, int primaryImage, int secondaryImage);


  /**
   * Method to add search layout to tool bar.
   */
  void addSearchOnToolbar();

  /**
   * Method to hide search layout on toolbar
   */
  void hideSearchOnToolbar();
}

package com.myapp.f2c.listener;

/**
 * @author Rafique Mujawar
 * Date 07-08-2018
 */
public interface ToolbarActionListener {
  /**
   * Callback method to fragments when toolbar primary option is clicked.such as back, add
   * contacts and settings
   */
  void onPrimaryOptionClick();

  /**
   * Callback method to fragments when toolbar secondary option is clicked.such as music, chat
   * and search
   */
  void onSecondaryOptionClick();

  /**
   * Callback method to fragments when toggle button on toolbar is clicked
   *
   * @param isChecked boolean value
   */
  void onToggle(boolean isChecked);
  /**
   * Callback method to fragments when toolbar title is clicked.such as find people on echome
   */
  void onTitleClick();
}

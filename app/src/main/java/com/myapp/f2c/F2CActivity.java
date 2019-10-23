package com.myapp.f2c;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.myapp.common.Constant.F2CConstants;
import com.myapp.f2c.listener.ToolbarSetUpListener;


/**
 * Base activity for all the classes of this application
 *
 * @author Rafique Mujawar
 */
public abstract class F2CActivity extends AppCompatActivity implements ToolbarSetUpListener {
  final String TAG = this.getClass().getSimpleName();

  Toolbar mToolbar;
  ImageView mPrimaryButton, mSecondaryButton;
  TextView mToolbarTitle;
  private ProgressBar progressBar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  /**
   * Method to init tool bar before using it
   */
  void initToolbar() {
    mToolbar = findViewById(R.id.echome_toolbar);
    mPrimaryButton = findViewById(R.id.iv_toolbar_primary);
    mSecondaryButton = findViewById(R.id.iv_toolbar_secondary);
    mToolbarTitle = findViewById(R.id.toolbar_title);
  }

  /**
   * Method to setup tool bar as per requirement
   *
   * @param title          title of screen, pass null or empty if title not required
   * @param titleImage     resource id of title image, pass 0 to avoid title image
   * @param primaryImage   resource id of starting image, pass 0 if not required
   * @param secondaryImage resource id of end image, pass 0 if not required
   */
  @Override
  public void setUpToolbar(String title, int titleImage, int primaryImage, int secondaryImage) {
    mToolbar.setVisibility(View.VISIBLE);
    if (0 != primaryImage) {
      mPrimaryButton.setVisibility(View.VISIBLE);
      mPrimaryButton.setImageResource(primaryImage);
    } else {
      mPrimaryButton.setVisibility(View.GONE);
    }

    if (0 != secondaryImage) {
      mSecondaryButton.setImageResource(secondaryImage);
    } else {
      mSecondaryButton.setVisibility(View.GONE);
    }

    if (TextUtils.isEmpty(title)) {
      mToolbarTitle.setText(F2CConstants.EMPTY_STRING);
    } else {
      mToolbarTitle.setText(title);
    }

    if (0 == titleImage) {
      mToolbarTitle.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    } else {
      mToolbarTitle.setCompoundDrawablesWithIntrinsicBounds(getDrawable(titleImage), null, null,
          null);
    }

    mToolbarTitle.setVisibility(View.VISIBLE);

    //mToolbarSearch.setVisibility(View.GONE);
  }


  /**
   * Method to add search layout to tool bar.
   */
  @Override
  public void addSearchOnToolbar() {
    //mToolbarSearch.setVisibility(View.VISIBLE);
    mToolbarTitle.setVisibility(View.GONE);
  }

  /**
   * Method to hide search layout on toolbar
   */
  @Override
  public void hideSearchOnToolbar() {
    mToolbarTitle.setVisibility(View.VISIBLE);
    //mToolbarSearch.setVisibility(View.GONE);
  }

  /**
   * Method to show toolbar
   */
  void showProgressBar() {
    if (null != progressBar) {
      progressBar.setVisibility(View.VISIBLE);
      if (null != this) {
        progressBar.getIndeterminateDrawable()
            .setColorFilter(Color.GRAY, android.graphics.PorterDuff.Mode.MULTIPLY);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
      }
    }
  }

  /**
   * Method to hide progressbar
   */
  void hideProgressBar() {
    if (null != progressBar) {
      progressBar.setVisibility(View.GONE);     // To Hide ProgressBar
    }
    if (null != this) {
      getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }
  }

  /**
   * Method to set progressbar
   *
   * @param progressBar
   */
  void setProgressBar(ProgressBar progressBar) {
    this.progressBar = progressBar;
  }
}
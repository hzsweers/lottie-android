package com.airbnb.lottie;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

public class LottieAnimationView extends AppCompatImageView {

  @Nullable private LottieViewDelegate delegate;

  public LottieAnimationView(Context context) {
    super(context);
    init(null);
  }

  public LottieAnimationView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(attrs);
  }

  public LottieAnimationView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(attrs);
  }

  private void init(AttributeSet attrs) {
    delegate = LottieViewDelegate.create(this, attrs);
  }

  @Override public void setImageResource(int resId) {
    super.setImageResource(resId);
    if (delegate != null) {
      delegate.setImageResource(resId);
    }
  }

  @Override public void setImageDrawable(Drawable drawable) {
    if (delegate != null) {
      delegate.setImageDrawable(drawable);
    }
    super.setImageDrawable(drawable);
  }

  @Override public void invalidateDrawable(Drawable dr) {
    super.invalidateDrawable(delegate != null ? delegate.invalidateDrawable(dr) : dr);
  }

  @Override protected Parcelable onSaveInstanceState() {
    Parcelable superState = super.onSaveInstanceState();
    return delegate != null ? delegate.onSaveInstanceState(superState) : superState;
  }

  @Override protected void onRestoreInstanceState(Parcelable state) {
    super.onRestoreInstanceState(delegate != null ? delegate.onRestoreInstanceState(state) : state);
  }

  @Override protected void onDetachedFromWindow() {
    if (delegate != null) {
      delegate.onDetachedFromWindow();
    }
    super.onDetachedFromWindow();
  }

  @Nullable public LottieViewDelegate getLottieViewDelegate() {
    return delegate;
  }

  public void setLottieViewDelegate(@Nullable LottieViewDelegate delegate) {
    this.delegate = delegate;
  }

}

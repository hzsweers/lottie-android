package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.airbnb.lottie.LottieViewDelegate.CacheStrategy;

import org.json.JSONObject;

/**
 * This delegate will load, deserialize, and display an After Effects animation exported with
 * bodymovin (https://github.com/bodymovin/bodymovin). This view is powered by a
 * {@link LottieViewDelegate} under the hood.
 * <p>
 * You may set the animation in one of two ways:
 * 1) Attrs: {@link R.styleable#LottieAnimationView_lottie_fileName}
 * 2) Programatically: {@link #setAnimation(String)}, {@link #setComposition(LottieComposition)},
 * or {@link #setAnimation(JSONObject)}.
 * <p>
 * You can set a default cache strategy with {@link R.attr#lottie_cacheStrategy}.
 * <p>
 * You can manually set the progress of the animation with {@link #setProgress(float)} or
 * {@link R.attr#lottie_progress}
 */
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

  private void init(@Nullable AttributeSet attrs) {
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

  /**
   * Sets the internal {@link LottieViewDelegate}.
   *
   * @param delegate the delegate.
   */
  public void setLottieViewDelegate(@Nullable LottieViewDelegate delegate) {
    this.delegate = delegate;
  }

  /**
   * Proxy to {@link LottieViewDelegate#setAnimation(String)}
   */
  public void setAnimation(String animationName) {
    if (delegate != null) {
      delegate.setAnimation(animationName);
    }
  }

  /**
   * Proxy to {@link LottieViewDelegate#setAnimation(String, CacheStrategy)}
   */
  @SuppressWarnings("WeakerAccess") public void setAnimation(final String animationName,
      final CacheStrategy cacheStrategy) {
    if (delegate != null) {
      delegate.setAnimation(animationName, cacheStrategy);
    }
  }

  /**
   * Proxy to {@link LottieViewDelegate#setAnimation(JSONObject)}
   */
  public void setAnimation(final JSONObject json) {
    if (delegate != null) {
      delegate.setAnimation(json);
    }
  }

  /**
   * Proxy to {@link LottieViewDelegate#setComposition(LottieComposition)}
   */
  public void setComposition(@NonNull LottieComposition composition) {
    if (delegate != null) {
      delegate.setComposition(composition);
    }
  }

  /**
   * Proxy to {@link LottieViewDelegate#hasMasks()}
   */
  @SuppressWarnings("unused") public boolean hasMasks() {
    return delegate != null && delegate.hasMasks();
  }

  /**
   * Proxy to {@link LottieViewDelegate#hasMatte()}
   */
  @SuppressWarnings("unused") public boolean hasMatte() {
    return delegate != null && delegate.hasMatte();
  }

  /**
   * Proxy to {@link LottieViewDelegate#setImageAssetsFolder(String)}
   */
  @SuppressWarnings("WeakerAccess") public void setImageAssetsFolder(String imageAssetsFolder) {
    if (delegate != null) {
      delegate.setImageAssetsFolder(imageAssetsFolder);
    }
  }

  /**
   * Proxy to
   * {@link LottieViewDelegate#addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener)}
   */
  public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener updateListener) {
    if (delegate != null) {
      delegate.addAnimatorUpdateListener(updateListener);
    }
  }

  /**
   * Proxy to {@link LottieViewDelegate#removeUpdateListener(ValueAnimator.AnimatorUpdateListener)}
   */
  @SuppressWarnings("unused") public void removeUpdateListener(
      ValueAnimator.AnimatorUpdateListener updateListener) {
    if (delegate != null) {
      delegate.removeUpdateListener(updateListener);
    }
  }

  /**
   * Proxy to {@link LottieViewDelegate#addAnimatorListener(Animator.AnimatorListener)}
   */
  public void addAnimatorListener(Animator.AnimatorListener listener) {
    if (delegate != null) {
      delegate.addAnimatorListener(listener);
    }
  }

  /**
   * Proxy to {@link LottieViewDelegate#removeAnimatorListener(Animator.AnimatorListener)}
   */
  @SuppressWarnings("unused") public void removeAnimatorListener(
      Animator.AnimatorListener listener) {
    if (delegate != null) {
      delegate.removeAnimatorListener(listener);
    }
  }

  /**
   * Proxy to {@link LottieViewDelegate#loop(boolean)}
   */
  public void loop(boolean loop) {
    if (delegate != null) {
      delegate.loop(loop);
    }
  }

  /**
   * Proxy to {@link LottieViewDelegate#isAnimating()}
   */
  public boolean isAnimating() {
    return delegate != null && delegate.isAnimating();
  }

  /**
   * Proxy to {@link LottieViewDelegate#playAnimation()}
   */
  public void playAnimation() {
    if (delegate != null) {
      delegate.playAnimation();
    }
  }

  /**
   * Proxy to {@link LottieViewDelegate#resumeAnimation()}
   */
  public void resumeAnimation() {
    if (delegate != null) {
      delegate.resumeAnimation();
    }
  }

  /**
   * Proxy to {@link LottieViewDelegate#reverseAnimation()}
   */
  @SuppressWarnings("unused") public void reverseAnimation() {
    if (delegate != null) {
      delegate.reverseAnimation();
    }
  }

  /**
   * Proxy to {@link LottieViewDelegate#resumeReverseAnimation()}
   */
  @SuppressWarnings("unused") public void resumeReverseAnimation() {
    if (delegate != null) {
      delegate.resumeReverseAnimation();
    }
  }

  /**
   * Proxy to {@link LottieViewDelegate#setSpeed(float)}
   */
  @SuppressWarnings("unused") public void setSpeed(float speed) {
    if (delegate != null) {
      delegate.setSpeed(speed);
    }
  }

  void setScale(float scale) {
    if (delegate != null) {
      delegate.setScale(scale);
    }
  }

  /**
   * Proxy to {@link LottieViewDelegate#cancelAnimation()}
   */
  public void cancelAnimation() {
    if (delegate != null) {
      delegate.cancelAnimation();
    }
  }

  /**
   * Proxy to {@link LottieViewDelegate#pauseAnimation()}
   */
  public void pauseAnimation() {
    if (delegate != null) {
      delegate.pauseAnimation();
    }
  }

  /**
   * Proxy to {@link LottieViewDelegate#setProgress(float)}
   */
  public void setProgress(@FloatRange(from = 0f, to = 1f) float progress) {
    if (delegate != null) {
      delegate.setProgress(progress);
    }
  }

  /**
   * Proxy to {@link LottieViewDelegate#getProgress()}
   */
  @FloatRange(from = 0.0f, to = 1.0f) public float getProgress() {
    return delegate != null ? delegate.getProgress() : 0;
  }

  /**
   * Proxy to {@link LottieViewDelegate#getDuration()}
   */
  @SuppressWarnings("unused") public long getDuration() {
    return delegate != null ? delegate.getDuration() : 0;
  }

}

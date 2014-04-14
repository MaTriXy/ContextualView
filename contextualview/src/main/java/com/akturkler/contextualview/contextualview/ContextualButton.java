/*
 * Copyright 2014 Emre Akturk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.akturkler.contextualview.contextualview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * @author Emre Akturk
 */
abstract class ContextualButton extends Button {

    public ContextualButton(Context context) {
        super(context);
        init();
    }

    private final void init() {
        setBackgroundColor(Color.TRANSPARENT);
        setDefaultLayoutParams();
        setDefaultId();
        setDefaultText();
    }

    private void setDefaultLayoutParams() {
        LinearLayout.LayoutParams tempLayoutParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
        tempLayoutParams.weight = 1;
        setLayoutParams(tempLayoutParams);
    }

    private void setDefaultId() {
        setId(getDefaultId());
    }

    public abstract int getDefaultId();

    public abstract void setDefaultText();

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                getBackground().setColorFilter(Color.argb(150, 255, 255, 255), PorterDuff.Mode.LIGHTEN);
                break;
            case MotionEvent.ACTION_UP:
                getBackground().setColorFilter(null);
                break;
            case MotionEvent.ACTION_CANCEL:
                getBackground().setColorFilter(null);
                break;
        }

        invalidate();
        return super.onTouchEvent(event);
    }
}

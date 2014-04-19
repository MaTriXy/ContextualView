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
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * @author Emre Akturk
 */
public final class ContextualBar extends LinearLayout implements View.OnClickListener {
    private PositiveContextualButton mPositiveButton;
    private NegativeContextualButton mNegativeButton;
    private onContextualBarClickListener mListener;

    public ContextualBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode())
            init();
    }

    private void init() {
        addPositiveButton();
        addDivider();
        addNegativeButton();
    }

    private void addPositiveButton() {
        mPositiveButton = new PositiveContextualButton(getContext());
        mPositiveButton.setOnClickListener(this);
        addView(mPositiveButton);
    }

    private void addNegativeButton() {
        mNegativeButton = new NegativeContextualButton(getContext());
        mNegativeButton.setOnClickListener(this);
        addView(mNegativeButton);

    }

    private void addDivider() {
        DividerView tempDividerView = new DividerView.Builder(getContext()).setColor(Color.BLACK).setWidth(10).build();
        addView(tempDividerView);
    }

    @Override
    public void onClick(View view) {
        if (mListener == null)
            return;

        switch (view.getId()) {
            case PositiveContextualButton.ID:
                mListener.onPositiveContextualButtonClick();
                return;
            case NegativeContextualButton.ID:
                mListener.onNegativeContextualButtonClick();
                return;
        }
    }

    public void setOnContextualBarClickListener(onContextualBarClickListener callback) {
        this.mListener = callback;
    }

    public static interface onContextualBarClickListener {
        void onPositiveContextualButtonClick();

        void onNegativeContextualButtonClick();
    }
}

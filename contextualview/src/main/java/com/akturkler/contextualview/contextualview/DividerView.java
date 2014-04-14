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
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * @author Emre Akturk
 */
class DividerView extends View {
    private int mWidth;
    private int mColor;

    private DividerView(Context context, Builder builder) {
        super(context);
        this.mWidth = builder.mWidth;
        this.mColor = builder.mColor;
        init();
    }

    private void init() {
        setDefaultLayoutParams();
        setBackgroundColor(mColor);
    }

    private void setDefaultLayoutParams() {
        LinearLayout.LayoutParams tempLayoutParams = new LinearLayout.LayoutParams(mWidth, ViewGroup.LayoutParams.MATCH_PARENT);
        setLayoutParams(tempLayoutParams);
    }

    public static class Builder {
        private Context mContext;
        private int mWidth;
        private int mColor;

        public Builder(Context context) {
            mContext = context;
        }

        public Builder setWidth(int width) {
            this.mWidth = width;
            return this;
        }

        public Builder setColor(int color) {
            this.mColor = color;
            return this;
        }

        public DividerView build() {
            return new DividerView(mContext, this);
        }

    }

}

/*
 * Copyright (C) 2021 Ancient OS
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

package com.android.systemui.nabil_aba;

import android.widget.TextView;
import android.content.Context;
import android.util.AttributeSet;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;

public class batterypercent extends textstatusbar{
    public batterypercent(Context c, AttributeSet a) {
        super(c,a);
        getContext().registerReceiver(nabilgtg, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

    }

    private BroadcastReceiver nabilgtg = new BroadcastReceiver() {
        @Override
        public void onReceive(Context c, Intent i) {
            int level = i.getIntExtra("level", 0);
            setText(Integer.toString(level) + "%");
        }

    };
}

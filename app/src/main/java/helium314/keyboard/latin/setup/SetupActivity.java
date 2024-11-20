/*
 * Copyright (C) 2013 The Android Open Source Project
 * modified
 * SPDX-License-Identifier: Apache-2.0 AND GPL-3.0-only
 */

package helium314.keyboard.latin.setup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import java.util.Locale;

public final class SetupActivity extends Activity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the locale to Portuguese before starting the next activity
        // Muda o idioma do app para portugues uhuuul
        updateLocale(this);

        final Intent intent = new Intent();
        intent.setClass(this, SetupWizardActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        if (!isFinishing()) {
            finish();
        }
    }

    // Method to update locale to Portuguese
    private void updateLocale(Context context) {
        Locale locale = new Locale("pt", "BR"); // "pt" for Portuguese
        Locale.setDefault(locale);

        Configuration config = context.getResources().getConfiguration();
        config.setLocale(locale);

        // Create a new context with the updated locale
        context.createConfigurationContext(config);
    }
}

/*
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */
package it.finanze.sanita.fse.generalarchetype.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import static it.finanze.sanita.fse.generalarchetype.config.Constants.Profile.TEST;
import static it.finanze.sanita.fse.generalarchetype.config.Constants.Profile.DEV;
import static it.finanze.sanita.fse.generalarchetype.config.Constants.Profile.DOCKER;

@Component
public class ProfileUtility {

    @Autowired
    private Environment environment;

    public boolean isTestProfile() {
        if (environment != null && environment.getActiveProfiles().length > 0) {
            return environment.getActiveProfiles()[0].toLowerCase().contains(TEST);
        }
        return false;
    }

    public boolean isDevOrDockerProfile() {
        if (environment != null && environment.getActiveProfiles().length > 0) {
            return environment.getActiveProfiles()[0].toLowerCase().contains(DEV) || environment.getActiveProfiles()[0].toLowerCase().contains(DOCKER);
        }
        return false;
    }
}
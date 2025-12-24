package org.devops.ansible

class LintCheck {
    static void run(script, String role) {
        script.sh """
        ansible-lint roles/${role}
        """
    }
}

package org.devops.ansible

class LintCheck {
    static void run(Map config) {
        def script = config.script
        def role   = config.role

        script.sh """
        ansible-lint roles/${role}
        """
    }
}

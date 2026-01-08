package org.devops.ansible

class LintCheck {

    def run(steps, String roleName) {
        steps.sh """
        ansible-lint roles/${roleName}
        """
    }
}

package org.devops.ansible

class LintCheck {

    def run(steps, String rolesPath, String roleName) {
        steps.sh """
        ansible-lint ${rolesPath}/${roleName}
        """
    }
}

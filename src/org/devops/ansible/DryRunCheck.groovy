package org.devops.ansible

class DryRunCheck {
    static void run(script, String testPlaybook) {
        script.sh """
        ansible-playbook ${testPlaybook} --check --diff
        """
    }
}

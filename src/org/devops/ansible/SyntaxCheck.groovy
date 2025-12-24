package org.devops.ansible

class SyntaxCheck {
    static void run(script, String role) {
        script.sh """
        ansible-playbook tests/test.yml --syntax-check -e "role=${role}"
        """
    }
}

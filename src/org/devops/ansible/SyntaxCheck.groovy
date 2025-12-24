package org.devops.ansible

class SyntaxCheck {
    static void run(Map config) {
        def script = config.script

        script.sh """
        ANSIBLE_ROLES_PATH=roles \
        ansible-playbook \
          -i tests/inventory/dev.ini \
          tests/test.yml \
          --syntax-check
        """
    }
}

package org.devops.ansible

class SyntaxCheck {
    static void run(Map config) {
        def script = config.script
        def role = config.role

        script.sh """
        ansible-playbook -i inventory/dev.ini playbooks/roles/${role}/tasks/main.yml --syntax-check
        """
    }
}

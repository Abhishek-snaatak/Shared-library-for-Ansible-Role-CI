package org.devops.ansible

class SyntaxCheck {
    static void run(Map config) {
        def script = config.script
        def role = config.role

        // Dynamically use role name if you want to target specific role
        def playbookPath = "tests/test.yml"
        def inventoryPath = "tests/inventory/dev.ini"

        script.sh """
            ansible-playbook -i ${inventoryPath} ${playbookPath} --syntax-check
        """
    }
}

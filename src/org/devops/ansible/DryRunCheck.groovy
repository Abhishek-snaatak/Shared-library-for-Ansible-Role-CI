package org.devops.ansible

class DryRunCheck {

    def run(steps,
         {

        steps.sh """
        ansible-playbook \
          -i ${inventory} \
          ${playbook} \
          --check --diff
        """
    }
}

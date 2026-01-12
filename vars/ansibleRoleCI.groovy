import org.devops.ansible.SyntaxCheck
import org.devops.ansible.LintCheck
import org.devops.ansible.DryRunCheck

def call(Map config = [:]) {

    String roleName  = config.roleName
    String playbook  = config.playbook
    String inventory = config.inventory ?: 'inventory/dev.ini'
    String rolesPath = config.rolesPath ?: 'playbooks/roles'

    stage("Syntax Check - ${roleName}") {
        new SyntaxCheck().run(this, inventory, playbook, rolesPath)
    }

    stage("Lint Check - ${roleName}") {
        new LintCheck().run(this, rolesPath, roleName)
    }

    stage("Dry Run - ${roleName}") {
        new DryRunCheck().run(this, playbook, inventory, rolesPath)
    }
}

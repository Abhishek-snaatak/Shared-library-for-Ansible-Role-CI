import org.devops.ansible.SyntaxCheck
import org.devops.ansible.LintCheck
import org.devops.ansible.DryRunCheck

def call(Map config = [:]) {

    String roleName  = config.roleName
    String playbook  = config.playbook  ?: 'tests/test.yml'
    String inventory = config.inventory ?: 'tests/inventory/dev.ini'

    stage("Syntax Check - ${roleName}") {
        new SyntaxCheck().run(this, inventory, playbook)
    }

    stage("Lint Check - ${roleName}") {
        new LintCheck().run(this, roleName)
    }

    stage("Dry Run - ${roleName}") {
        new DryRunCheck().run(this, playbook, inventory)
    }
}

import org.devops.ansible.SyntaxCheck
import org.devops.ansible.LintCheck
import org.devops.ansible.DryRunCheck

def call(String roleName,
         String playbook  = "tests/test.yml",
         String inventory = "tests/inventory/dev.ini") {

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

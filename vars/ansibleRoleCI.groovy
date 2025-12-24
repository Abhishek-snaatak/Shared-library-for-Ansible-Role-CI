import org.devops.ansible.SyntaxCheck
import org.devops.ansible.LintCheck
import org.devops.ansible.DryRunCheck

def call(Map config) {
    stage("Syntax Check for Role: ${config.roleName}") {
        SyntaxCheck.run(script: this, role: config.roleName)
    }

    stage("Lint Check for Role: ${config.roleName}") {
        LintCheck.run(script: this, role: config.roleName)
    }

    stage("Dry Run for Role: ${config.roleName}") {
        DryRunCheck.run(script: this, testPlaybook: config.testPlaybook)
    }
}

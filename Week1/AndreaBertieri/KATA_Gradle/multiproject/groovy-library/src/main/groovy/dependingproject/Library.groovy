package dependingproject

import groovy.transform.CompileStatic

@CompileStatic
class Library {
    static String greeting(final String name) {
        "Hello, ${name.capitalize()}"
    }
}

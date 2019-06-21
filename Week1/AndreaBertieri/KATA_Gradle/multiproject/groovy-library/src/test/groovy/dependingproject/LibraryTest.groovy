package dependingproject

import spock.lang.Specification

class LibraryTest extends Specification {

    def 'Creating a greeting'() {

        expect: 'The greeting to be correctly capitalized'
        Library.greeting('gradlephant') == 'Hello, Gradlephant'

    }
}

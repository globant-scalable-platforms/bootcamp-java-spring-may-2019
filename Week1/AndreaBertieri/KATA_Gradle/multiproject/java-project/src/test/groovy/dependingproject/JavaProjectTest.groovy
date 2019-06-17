package dependingproject

import spock.lang.Specification

class JavaProjectTest extends Specification {

    def 'Calling the entry point'() {

	setup: 'Re-route standart out'
	def buf= new ByteArrayOutputStream(1024)
	System.out = new PrintStream(buf)

	when: 'The entry point is executed'
        JavaProject.main('gradlephant')

        then: 'The correct greeting is output'
        buf.toString() == "Hello, Gradlephant\n".denormalize()

    }
}

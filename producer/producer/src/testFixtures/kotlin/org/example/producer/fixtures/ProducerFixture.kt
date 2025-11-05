package org.example.producer.fixtures

import org.example.b.fixtures.TestFixtureB

class ProducerFixture {
  fun useConsumerB() {
    val b = TestFixtureB()
  }
}
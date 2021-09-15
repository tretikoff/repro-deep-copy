// doesn't compile
fun <T : Any> MyRadioGroup(checkedValue: T?) {}

// compiles
// fun <T : Any> MyRadioGroup(checkedValue: T) {}

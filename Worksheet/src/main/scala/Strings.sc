/**
 * Strings are also special collections. They are not sequences usually, but are compatible with them just like Arrays.
 * Strings also undergo two kinds of implicit conversions:
 * 1. Low priority conversion to WrappedString which is a subclass of IndexedSeq.
 * 2. High priority conversion to StringOps just like ArrayOps.
 */
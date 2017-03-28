/**
 * 
 */
package fr.n7.stl.block.ast;

/**
 * Elementary types in the Bloc language.
 * @author Marc Pantel
 *
 */
public enum AtomicType implements Type {
	BooleanType,
	CharacterType,
	FloatingType,
	IntegerType,
	StringType,
	VoidType,
	ErrorType
	;

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#equalsTo(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean equalsTo(Type _other) {
		return this == _other;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#compatibleWith(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean compatibleWith(Type _other) {
		if (this.equalsTo(_other)) {
			return true;
		} else {
			switch (this) {
			case IntegerType: return _other == FloatingType;
			case BooleanType: return _other == IntegerType;
			default: return false;
			}
		}
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#merge(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public Type merge(Type _other) {
		if (this.compatibleWith(_other)) {
			return _other;
		} else {
			if (_other.compatibleWith(this)) {
				return this;
			} else {
				return ErrorType;
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#length()
	 */
	@Override
	public int length() {
		switch (this) {
			case BooleanType :
			case CharacterType :
			case FloatingType :
			case IntegerType :
			case StringType : return 1;
			case VoidType : return 0;
			default : throw new IllegalArgumentException( "Must not call length on the Error type.");
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		switch (this) {
		case BooleanType: return "boolean";
		case CharacterType: return "char";
		case ErrorType: return "error";
		case FloatingType: return "float";
		case IntegerType: return "int";
		case StringType: return "String";
		case VoidType: return "void";
		default: throw new IllegalArgumentException( "The default case should never be triggered.");
		}
	}

}

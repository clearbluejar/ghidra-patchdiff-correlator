package patchdiffcorrelator;

import ghidra.feature.vt.api.main.VTProgramCorrelator;
import ghidra.feature.vt.api.util.VTOptions;
import ghidra.program.model.address.AddressSetView;
import ghidra.program.model.listing.Program;

public class BulkBasicBlockMnemonicProgramCorrelatorFactory extends AbstractBulkProgramCorrelatorFactory {
	static final String DESC = "Compares functions based on their instruction mnemonics within basic blocks without taking the order of the basic blocks into account.";
	static final String NAME = "Bulk Basic Block Mnemonics Match";
	
	@Override
	protected VTProgramCorrelator doCreateCorrelator(
			Program sourceProgram, AddressSetView sourceAddressSet, Program destinationProgram,
			AddressSetView destinationAddressSet, VTOptions options) {
		return new BulkProgramCorrelator(sourceProgram, sourceAddressSet,
			destinationProgram, destinationAddressSet, options, NAME, BasicBlockMnemonicFunctionBulker.INSTANCE);
	}
	
	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public String getDescription() {
		return DESC;
	}
}

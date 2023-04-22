package org.zhr.core.command;

import java.io.Serializable;

public interface CommandProcessor<R extends Serializable> {

    R process(final CommandContext context) throws Exception;

}
